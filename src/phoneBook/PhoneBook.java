package phoneBook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {

	HashMap<String, HashMap<String, PhoneBookInfo>> phonebook = new HashMap<>();

	public PhoneBook() {

	}

	/*
	< String, HashMap<> >
	phonebook
	Key : 그룹명
	Value : 해당 그룹맵

	phonebook.get() ┌ Family, new HashMap<>()
	                │           └→ 새로운 해쉬맵을 만들어야 가족, 친구가 따로 만들어진다(?)
	                └ Friends, new HashMape<>()
	                            └→ 새로운 해쉬맵을 만들어야 가족, 친구가 따로 만들어진다(?)
	 */

	// 그룹명 추가 여부
	// 새로운 그룹을 추가하는 메서드
	public boolean addGroup (String groupName) {
		// 폰북에 그룹명이 없으면 추가O
		if (!phonebook.containsKey(groupName)) {
			// 그룹명 하나 당 해쉬맵을 하나씩 만들어줘야 그룹마다 새로운 사람을 추가 할 수 있다.
			phonebook.put(groupName, new HashMap<>());
			// 안내메세지(출력 메세지)는 굳이 안 넣는게 좋다.
			// 이런 문구 없는 게 낫다....
			System.out.printf("그룹 [%s]을(를) 성공적으로 생성했습니다.\n", groupName ); 
			return true;
		}
		// 폰북에 그룹명이 있으면 추가X
		System.out.println("이미 존재하는 그룹입니다.");
		return false;
	}

	// 동일인물의 존재여부
	// 겹치는 전화번호가 있는지 검사
	public boolean personAlreadyExistOtherGroup(PhoneBookInfo info) {

		boolean exist = false;

		for (String groupName : phonebook.keySet()) {  // 그룹 이름을 하나씩 꺼냄
			if(groupName.equals(info.group)) {
				continue;
			}

			//phonebook.keySet() : 그룹이름을 하나씩 꺼내는 것 = new HashMap()을 하나씩 꺼내는 것
			HashMap<String, PhoneBookInfo> groupMap = phonebook.get(groupName);

			// get(K) : 키값에 해당하는 Value를 꺼낸다. 키를 찾지못하면 null이 반환됨
			// 이번호로 존재하는 사람이 하나라도 있으면 false, 존재하는 사람이 없으면 true
			exist = exist || groupMap.containsKey(info.phoneNumber);  
			// --> ||이므로 하나라도 true이면 true

			// 해당 폰 넘버가 그룹을 돌면서 하나라도 존재하면 true
			// 가족 그룹멤버에 컨테인즈 키를 꺼냈는데 동일인물이 안 나왔다 ⇒ false(?)
			exist = exist || groupMap.containsKey(info.phoneNumber); 
			// phoneNumber로 존재하는 사람이 없으면 false가 나온다(?)
		}
		return exist;
	}

	//그룹에 전화번호 및 개인정보를 추가하는 메서드
	public boolean addPerson (PhoneBookInfo info) {

		if (personAlreadyExistOtherGroup(info)) {
			System.out.println("다른 그룹에 이미 등록된 전화번호 입니다.");
			return false;
		}

		if (phonebook.containsKey(info.group)) {
			HashMap<String, PhoneBookInfo> groupMap =
					phonebook.get(info.group);

			if (groupMap.containsKey(info.phoneNumber)) {
				System.out.printf("'%s'님의 정보를 수정했습니다.\n", info.name);
			} else {
				System.out.println("새로운 정보를 등록했습니다");
			}
			groupMap.put(info.phoneNumber, info); // put(K, V) : 해당 키에 값을 저장한다
			return true;
		} else {
			System.out.println("해당 그룹이 존재하지 않아 추가 실패.");
			return false;
		}
	}

	// 이름의 일부를 입력하면 일치하는 모든 사람의 목록을 보여주는 메서드
	public void searchByName(String nameFrag) {
		for (HashMap<String, PhoneBookInfo> group : phonebook.values()) {
			for (PhoneBookInfo info : group.values()) {
				if (info.name.contains(nameFrag)) {
					System.out.println(info);
				}
			}
		}
	}

	// 전화번호의 일부를 입력하면 일치하는 모든 사람의 목록을 보여주는 메서드
	public void searchByPhoneNumber(String phoneNumberFrag) {
		for (HashMap<String, PhoneBookInfo> group : phonebook.values()) {
			for (PhoneBookInfo info : group.values()) {
				if (info.phoneNumber.contains(phoneNumberFrag)) {
					System.out.println(info);
				}
			}
		}
	}

	// 등록된 모든 정보를 그룹명 순으로 출력, 같은 그룹내에서는 이름 기준 오름차순으로 출력하는 메서드
	public void printAll() {
		List<PhoneBookInfo> allInfo = new ArrayList<>();

		for (HashMap<String, PhoneBookInfo> group : phonebook.values()) {
			// forEach : 배열, 리스트, 집합 등에서 요소를 하나씩 꺼내며 반복하는 문법
			for (PhoneBookInfo info : group.values()) { 
				allInfo.add(info);
			}
		}

		Collections.sort(allInfo, new Comparator<PhoneBookInfo>() {

			@Override
			public int compare(PhoneBookInfo i1, PhoneBookInfo i2) {
				int r1 = i1.group.compareTo(i2.group);

				if (r1 == 0) {
					return i1.name.compareTo(i2.name); // 같을 때는 이름 순으로
				} else {
					return r1;
				}
			}
		});

		System.out.println("### Print All Info ###");
		for (PhoneBookInfo info : allInfo) {
			System.out.println(info);
		}
	} 	
}
