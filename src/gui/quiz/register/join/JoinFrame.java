package gui.quiz.register.join;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui.quiz.register.dao.RegisterDAO;
import gui.quiz.register.model.Member;


public class JoinFrame extends JFrame {
	
	RegisterDAO register = new gui.quiz.register.dao.RegisterDAO();
	
	JFrame child = this;
	JFrame parent;

	//아이디, 이름, 나이, 주민등록번호 맨 앞자리까지, 관심분야, SMS수신 동의 여부, 이메일, 핸드폰 번호
	JLabel joinIdLabel = new JLabel() {
		{
			setText("아이디");
			setLocation(30, 50);
			setSize(100, 30);
		}
	};
	
	
	JLabel joinPwLabel = new JLabel() {
		{
			setText("비밀번호");
			setLocation(30, 100);
			setSize(100, 30);
		}
	};
	
	JLabel joinNameLabel = new JLabel() {
		{
			setText("이름");
			setLocation(30, 150);
			setSize(100, 30);
		}
	};
	
	JLabel joinAgeLabel = new JLabel() {
		{
			setText("나이");
			setLocation(30, 200);
			setSize(100, 30);
		}
	};
	
	JLabel joinBirthLabel = new JLabel() {
		{
			setText("생년월일");
			setLocation(30, 250);
			setSize(100, 30);
		}
	};
	
	JLabel joinEmailLabel = new JLabel() {
		{
			setText("이메일");
			setLocation(30, 300);
			setSize(100, 30);
		}
	};
	
	JLabel joinPhoneNumberLabel = new JLabel() {
		{
			setText("연락처");
			setLocation(30, 350);
			setSize(100, 30);
		}
	};
	
	JLabel joinInterestLabel = new JLabel() {
		{
			setText("관심분야");
			setLocation(30, 400);
			setSize(100, 30);
		}
	};
	
	JLabel joinSMSLabel = new JLabel() {
		{
			setText("SMS 수신여부");
			setLocation(30, 450);
			setSize(100, 30);
		}
	};
	
	
	
	
	
	JTextField id_field = new JTextField("abc123") {
		{
			setBounds(120, 50, 200, 30);
		}
	};
	
	JPasswordField pw_field = new JPasswordField("1234") {
		{
			setBounds(120, 100, 200, 30);
		}
	};

	JTextField name_field = new JTextField("김말이") {
		{
			setBounds(120, 150, 200, 30);
		}
	};

	JTextField age_field = new JTextField("23") {
		{
			setBounds(120, 200, 200, 30);
		}
	};

	JTextField social_number_field = new JTextField("881111-1") {
		{
			setBounds(120, 250, 200, 30);
		}
	};
	
	JTextField gender_field = new JTextField("성별") {
		{
			setBounds(330, 250, 30, 30);
		}
	};
	
	JTextField email_field = new JTextField("email@abc.com") {
		{
			setBounds(120, 300, 200, 30);
		}
	};

	JTextField phone_field = new JTextField("12312341234") {
		{
			setBounds(120, 350, 200, 30);
		}
	};



	// 관심분야
	JCheckBox soccer = new JCheckBox("축구") {
		{
			setBounds(120, 400, 50, 30);
		}
	};

	JCheckBox basketball = new JCheckBox("농구") {
		{
			setBounds(170, 400, 50, 30);
		}
	};

	JCheckBox movie = new JCheckBox("영화") {
		{
			setBounds(220, 400, 50, 30);
		}
	};

	JCheckBox drama = new JCheckBox("드라마") {
		{
			setBounds(270, 400, 66, 30);
		}
	};

	JCheckBox bike = new JCheckBox("자전거") {
		{
			setBounds(335, 400, 66, 30);
		}
	};



	List<JCheckBox> interest_fields = new ArrayList<>() {
		{
			add(soccer);
			add(basketball);
			add(movie);
			add(drama);
			add(bike);
		}
	}; 

	JCheckBox sms_box = new JCheckBox("SMS 수신 동의") {
		{
			setBounds(120, 450, 200, 30);
		}
	};
	
	JButton idDuple_Button = new JButton("중복확인") {
		{
			setBounds(330, 50, 90, 30);
		}
	};
	
	JButton pwDuple_Button = new JButton("재확인") {
		{
			setBounds(330, 100, 90, 30);
		}
	};
	
	JButton emailDuple_Button = new JButton("중복확인") {
		{
			setBounds(330, 300, 90, 30);
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					register.open();
				}
			});
		}
	};


	JButton join_button = new JButton("가입하기") {
		{
			setBounds(80, 500, 120, 30);
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// 입력값 검증
					if (!fieldValidate()) {
						return;
					}
					// DB에 회원 정보 쓰기
					Member mem = new Member();

					mem.setMem_id(id_field.getText());
					mem.setPhone_number(phone_field.getText());
					mem.setEmail(email_field.getText());
					mem.setMem_name(name_field.getText());
					mem.setAge(Integer.parseInt(age_field.getText()));
					mem.setSms(sms_box.isSelected());

					// "881111-1" : 7번째 문자열을 가져와서 성별을 구분한다.
					char ch = social_number_field.getText().charAt(7);

					if (ch == '1' || ch == '3') {
						mem.setGender("남");						
					} else {
						mem.setGender("여");
					}


					// year, month, date 나오게 만들기
					// 앞에 문자열 6개를 잘라서 넣어준다.
					int birth = Integer.parseInt(social_number_field.
							getText().substring(0,6));
					
					// java.sql.Date.valueOf(LocalDate) 기능 활용
					// 해당 메서드로 리턴되는 타입은 java.sql.Date이지만 java.sql.Date는 java.util.Date의 자식임 (업캐스팅 가능)
					mem.setBirthday(java.sql.Date.valueOf(LocalDate.of(
							(ch <= '2' ? 1900 : 2000) + birth / 10000,
							birth % 10000 / 100,
							birth % 100
							)));
					
					List<String> interests = new ArrayList<>();
					for (JCheckBox interest_field : interest_fields) {
						if(interest_field.isSelected()) {
							interests.add(interest_field.getName());
						}
					} 
					
					// 1개 또는 2개만 선택했을 때 null 채워서 3개 만들기
					while (interests.size() != 3) {
						interests.add(null);
					}
					
					// 필드값을 이미 1,2,3으로 정했기 때문에 반복문으로 돌리기 어려워서 List 배열로 만든다.
					mem.setInterest1(interests.get(0));
					mem.setInterest2(interests.get(1));
					mem.setInterest3(interests.get(2));
					
					
					String encrypted_password = 
							gui.quiz.register.module.PasswordEncryption.encrypt(pw_field.getPassword());
					System.out.println("encrypted : " + encrypted_password);
					mem.setPassword(encrypted_password);
					
					new gui.quiz.register.dao.RegisterDAO().registerMember(mem);
				}
			});
		}
	};

	JButton cancel_button = new JButton("취소") {
		{
			setBounds(250, 500, 120, 30);
			addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					parent.setVisible(true);	
					child.setVisible(false);
				}
			});
		}
	};


	// 미리 만들어져 있는 것
	public JoinFrame(JFrame parent) {
		this.parent = parent;

		add(id_field);
		add(name_field);
		add(age_field);
		add(social_number_field);
		add(gender_field);
		add(sms_box);
		add(email_field);
		add(phone_field);
		add(idDuple_Button);
		add(pwDuple_Button);
		add(emailDuple_Button);
		add(join_button);
		add(cancel_button);
		add(pw_field);
		add(joinIdLabel);
		add(joinPwLabel);
		add(joinNameLabel);
		add(joinAgeLabel);
		add(joinBirthLabel);
		add(joinInterestLabel);
		add(joinSMSLabel);
		add(joinEmailLabel);
		add(joinPhoneNumberLabel);


		// 분야 목록 리스트 여러 개 중에 하나를 뽑아서 하나씩 추가
		for(JCheckBox interest_field : interest_fields) {
			add(interest_field);
		}

		setLayout(null);
		setLocation(700, 200);
		setSize(450, 600);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);	
	}


	// 미리 만들어진 JoinFrame을 보이게 한다
	public void open() {
		setVisible(true);
		parent.setVisible(false); // 해당 프레임을 숨기는 메서드
	}


	// 검증 - 필드값에 이상이 없으면 통과
	public boolean fieldValidate() {
		return true;
	}
}
