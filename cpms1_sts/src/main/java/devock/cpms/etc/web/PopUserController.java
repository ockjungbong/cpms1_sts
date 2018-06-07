package devock.cpms.etc.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import devock.cpms.admin.organ.service.DeptService;
import devock.cpms.admin.organ.service.UserService;
import devock.cpms.common.util.TreeMaker;
import devock.cpms.common.vo.SearchVO;

@Controller
public class PopUserController {

    @Autowired
    private DeptService deptService;
    
    @Autowired
    private UserService userService;
    
    /**
     * 부서리스트.
     */
    @RequestMapping(value = "/popupDept.do")
       public String popupDept(ModelMap modelMap) throws Exception {
        List<?> listview   = deptService.selectDepartment();

        TreeMaker tm = new TreeMaker();
        String treeStr = tm.makeTreeByHierarchy(listview);
        
        modelMap.addAttribute("treeStr", treeStr);
        
        return "etc/popupDept";
    }
    
    /**
     *  부서리스트 for 사용자.
     */
    @RequestMapping(value = "/popupUser.do")
    public String popupUser(ModelMap modelMap) throws Exception {
        List<?> listview   = deptService.selectDepartment();

        TreeMaker tm = new TreeMaker();
        String treeStr = tm.makeTreeByHierarchy(listview);
        
        modelMap.addAttribute("treeStr", treeStr);
        
        return "etc/popupUser";
    }
    
    /**
     * 선택된 부서의 User 리스트.
     */
    @RequestMapping(value = "/popupUsersByDept.do")
    public String popupUsersByDept(HttpServletRequest request, SearchVO searchVO, ModelMap modelMap) throws Exception {
        String deptno = request.getParameter("deptno");
        searchVO.setSearchExt1(deptno);
        
        List<?> listview  = userService.selectUserListWithDept(searchVO);
        
        modelMap.addAttribute("listview", listview);
        
        return "etc/popupUsersByDept";
    }
    
    /**
     *  부서리스트 for 사용자들.
     */
    @RequestMapping(value = "/popupUsers")
    public String popupUsers(ModelMap modelMap) throws Exception {
        popupUser(modelMap);
        
        return "etc/popupUsers";
    }

    /**
     * User 리스트  for 사용자들.
     */
    @RequestMapping(value = "/popupUsers4Users") 
    public String popupUsers4Users(HttpServletRequest request, SearchVO searchVO, ModelMap modelMap) throws Exception {
        popupUsersByDept(request, searchVO, modelMap);
        
        return "etc/popupUsers4Users";
    }    

   
}
