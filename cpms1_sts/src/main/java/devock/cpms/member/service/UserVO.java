package devock.cpms.member.service;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import devock.cpms.common.validator.Phone;

public class UserVO {
    private String userno;    
   
    private String userid;  
    
    private String userpw;
 
    private String userpwCfm;
    
	private String usernm;
    
    @Phone
    private String phoneNumber;
    
    private String photo;
    private String userrole;
    private String ip;
    private String deptno;
    private String deptnm;

    /* 
     * 사진 
     */
    private MultipartFile photofile;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserpw() {
        return userpw;
    }

    public void setUserpw(String userpw) {
        this.userpw = userpw;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public String getUsernm() {
        return usernm;
    }

    public void setUsernm(String usernm) {
        this.usernm = usernm;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public MultipartFile getPhotofile() {
        return photofile;
    }

    public void setPhotofile(MultipartFile photofile) {
        this.photofile = photofile;
    }

    public String getDeptnm() {
        return deptnm;
    }

    public void setDeptnm(String deptnm) {
        this.deptnm = deptnm;
    }
    
    public String getUserpwCfm() {
		return userpwCfm;
	}

	public void setUserpwCfm(String userpwCfm) {
		this.userpwCfm = userpwCfm;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "UserVO [userno=" + userno + ", userid=" + userid + ", userpw=" + userpw + ", userpwCfm=" + userpwCfm
				+ ", usernm=" + usernm + ", phoneNumber=" + phoneNumber + ", photo=" + photo + ", userrole=" + userrole
				+ ", ip=" + ip + ", deptno=" + deptno + ", deptnm=" + deptnm + ", photofile=" + photofile + "]";
	}


    
    
}
