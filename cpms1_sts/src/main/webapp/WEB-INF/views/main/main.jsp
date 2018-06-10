<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<script>
function fn_moveDate(date){
    $.ajax({
        url: "moveDate",
        type:"post", 
        data : {date: date},
        success: function(result){
            $("#calenDiv").html(result);
        }
    })
}

// responsive week calendar
function myFunction(x) {
    if (x.matches) { // max-width: 450px
		var columnSelected = $("#weekDiv").children(".columnSelected");
		if (columnSelected.length===0) { // 반응형 시작
			var today = $("#weekDiv .today");
			if (today.length > 0) {  // 오늘이 있으면
				//today = today.parent();
				today.addClass( "columnSelected" );
				if (today.next().hasClass("calendarColumn")) { // 토요일(한주의 마지막)이 아니면
					today.next().addClass( "columnSelected" );
				}else {
					today.prev().addClass( "columnSelected" );
				}
			} else {				// 오늘이 없으면 일/월요일 
				var ch = $("#weekDiv").children(".calendarColumn").first();
				ch.addClass( "columnSelected" );
				ch.next().addClass( "columnSelected" );
			}
		}
	}
}

window.onload = function () {
	var x = window.matchMedia("(max-width: 450px)")
	x.addListener(myFunction) 
	myFunction(x) 
}

function ev_prevSlide() {
	var columnSelected = $("#weekDiv").children(".columnSelected");
	var node = columnSelected.first().prev();
	if (!node || !node.hasClass("calendarColumn")) return;
	
	node.addClass( "columnSelected" );
	if (node.prev().length===0) {
		$(".calenSlideButton_left").hide();
	}
	$(".calenSlideButton_right").show();

	columnSelected.last().removeClass( "columnSelected" );
}

function ev_nextSlide() {
	var columnSelected = $("#weekDiv").children(".columnSelected");
	var node = columnSelected.last().next();
	if (!node || !node.hasClass("calendarColumn")) return;
	
	node.addClass( "columnSelected" );

	if (!node.next().hasClass("calendarColumn")) {
		$(".calenSlideButton_right").hide();
	}
	$(".calenSlideButton_left").show();

	columnSelected.first().removeClass( "columnSelected" );
}

</script>
    
</head>

<body>

    <div id="wrapper">
    
        <div id="page-wrapper">
            <div id="calenDiv" class="row">
                <jsp:include page="mainCalen.jsp" />
            </div>

            <div class="row">
                <div class="col-lg-12">
                    &nbsp;
                </div>
            </div>
                
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-8">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-send fa-fw"></i> Recent News
                            <div class="pull-right"><a href="boardList">more</a>
                            </div>
                        </div>
                        <div class="panel-body">
                            <div class="col-lg-12">
                                <div class="listHead">
                                    <div class="listHiddenField pull-right field100"><s:message code="board.locate"/></div>
                                    <div class="listHiddenField pull-right field100"><s:message code="board.date"/></div>
                                    <div class="listHiddenField pull-right field100"><s:message code="board.writer"/></div>
                                    <div class="listTitle"><s:message code="board.title"/></div>
                                </div>
                                <c:forEach var="listview" items="${listview}" varStatus="status">    
                                    <c:url var="link" value="boardRead">
                                        <c:param name="brdno" value="${listview.brdno}" />
                                    </c:url>        
                                    <div class="listBody">
                                        <div class="listHiddenField pull-right field100"><c:out value="${listview.bgname}"/></div>
                                        <div class="listHiddenField pull-right field100"><c:out value="${listview.brddate}"/></div>
                                        <div class="listHiddenField pull-right field100"><c:out value="${listview.brdwriter}"/></div>
                                        <div class="listTitle" title="<c:out value="${listview.brdtitle}"/>">
                                            <a href="${link}"><c:out value="${listview.brdtitle}"/></a>
                                            <c:if test="${listview.replycnt>0}">
                                                (<c:out value="${listview.replycnt}"/>)
                                            </c:if>                                                
                                        </div>
                                        <div class="showField text-muted small">
                                            <c:out value="${listview.brdwriter}"/> <c:out value="${listview.brddate}"/>
                                        </div>
                                    </div>
                                </c:forEach>    
                            </div>                        
                        </div>
                    </div>
                </div>
                
                <div class="col-lg-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-volume-up fa-fw"></i> <s:message code="common.notice"/>
                        </div>
                        <div class="panel-body maxHeight400">
                            <c:forEach var="noticeList" items="${noticeList}" varStatus="status">    
                                <c:url var="link" value="boardRead">
                                    <c:param name="brdno" value="${noticeList.brdno}" />
                                </c:url>    
                                <a href="${link}">
                                <div class="listBody listTitle">
                                    <c:out value="${noticeList.brdtitle}"/>
                                </div>    
                                </a>
                            </c:forEach>
                        </div>
                    </div>

                    <!-- Time Line -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-clock-o fa-fw"></i> Time Line
                        </div>
                        <div class="panel-body maxHeight400">
                            <ul class="chat">
                                <c:forEach var="listtime" items="${listtime}" varStatus="status">
                                    <c:choose>
                                        <c:when test="${status.index % 2 eq 0}">
                                            <li class="left clearfix">
                                                    <c:choose>
                                                    <c:when test="${listtime.photo==null}">
                                                        <span class="chat-img pull-left img-circle">
                                                            <i class="glyphicon glyphicon-user noPhoto"></i>
                                                        </span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <!--  <img src="fileDownload?downname=<c:out value="${listtime.photo}"/>" title="<c:out value="${listtime.rewriter}"/>" class="chat-img pull-left img-circle"/>  -->
                                                    </c:otherwise>
                                                    </c:choose>                                                
                                                
                                            </li>                                    
                                        </c:when>
                                        <!--  
                                        <c:otherwise>
                                            <li class="right clearfix">
                                                <c:choose>
                                                <c:when test="${listtime.photo==null}">
                                                    <span class="chat-img pull-right img-circle">
                                                        <i class="glyphicon glyphicon-user noPhoto"></i>
                                                    </span>
                                                </c:when>
                                                <c:otherwise>
                                                    <img src="fileDownload?downname=<c:out value="${listtime.photo}"/>" title="<c:out value="${listtime.rewriter}"/>" class="chat-img pull-right img-circle"/> 
                                                </c:otherwise>
                                                </c:choose>
                                                
                                            </li>                                            
                                        </c:otherwise>
                                        -->
                                    </c:choose>
                                </c:forEach>
                            </ul>    
                        </div>
                    </div>                    
                    <!-- Time Line -->
                    
                </div>
                <!-- col-lg-4 -->
            </div>
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
</body>

</html>