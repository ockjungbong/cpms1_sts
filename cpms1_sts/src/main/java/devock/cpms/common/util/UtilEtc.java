package devock.cpms.common.util;


public class UtilEtc {
	 public static String text2Html(String txt) {
	        txt = txt.replaceAll(" ", "&nbsp");
	        return txt.replaceAll("\n", "<br>");
	    } 
}

