package kr.or.ddit.vo;

import java.io.IOException;
import java.io.Serializable;
import java.io.UncheckedIOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.LoginGroup;
import kr.or.ddit.validate.constraints.TelNumber;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *	회원 관리용 Domain Layer
 */
@Data
@EqualsAndHashCode(of = "memId")
@NoArgsConstructor
public class MemberVO implements Serializable {
	
	public MemberVO(String memId, String memPass) {
		super();
		this.memId = memId;
		this.memPass = memPass;
	}
	
//	@JsonIgnore 마샬링에서 제외
//	transient 직렬화에서 제외
//	@DateTimeFormat(iso = ISO.DATE_TIME) - json 데이터를 받을때만 동작함 (언마샬링, 역직렬화)
//	@JsonFormat(shape = Shape.STRING) - json 데이터를 보낼 때만 동작함 (마샬링, 직렬화)
	
	private int rnum;
//	hibernate validation 사용 - 주의사항으로 hibernate를 사용하면 안됨(인터페이스를 사용해야하기 때문) -> validation
	@NotBlank(groups = {InsertGroup.class, DeleteGroup.class, LoginGroup.class})
	private String memId;
	
	@NotBlank(groups = {Default.class, LoginGroup.class})
	@Size(min = 4, max = 12, groups = {Default.class, LoginGroup.class})
	private String memPass;
	
	@NotBlank(groups = InsertGroup.class) // 그룹 지정 거기에서만 사용하도록
	private String memName;
	
	@JsonIgnore
	@ToString.Exclude
	@Size(min = 6, max = 6)
	private transient String memRegno1;
	
	@JsonIgnore
	@ToString.Exclude
	private transient String memRegno2;
	
//	@JsonFormat(shape = Shape.STRING)
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime memBir;
	
	@NotBlank
	private String memZip;
	@NotBlank
	private String memAdd1;
	@NotBlank
	private String memAdd2;
	
	@TelNumber(regex = "\\d{2,3}\\)\\d{3,4}-\\d{4}") // 커스텀 어노테이션
	private String memHometel;
	
	@TelNumber // 커스텀 어노테이션
	private String memComtel;
	
	@NotBlank
	@TelNumber // 커스텀 어노테이션
	private String memHp;
	@Email
	private String memMail;
	private String memJob;
	private String memLike;
	private String memMemorial;
	
//	@JsonFormat(shape = Shape.STRING)
	@DateTimeFormat(iso =ISO.DATE)
	private LocalDate memMemorialday;
	private Integer memMileage;
	private boolean memDelete;
	
	// Has Many 관계
	@JsonIgnore
	private transient List<CartVO> cartList;
	// MEMBER(1) : CART[PROD(1)](N)
	
	private String memRole;
	
	private byte[] memImg; // 데이터베이스 연결용
	private MultipartFile memImage; // 클라이언트 업로드 파일 수신용
	
	public void setMemImage(MultipartFile memImage) {
		if(memImage==null || memImage.isEmpty()) return;
		this.memImage = memImage;
		try {
			this.memImg = memImage.getBytes();
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	public String getBase64Img() {
		if(memImg==null) return null;
		else 
			return Base64.getEncoder().encodeToString(memImg);
	}
}