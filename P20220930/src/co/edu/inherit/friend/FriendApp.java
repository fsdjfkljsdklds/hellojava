package co.edu.inherit.friend;

public class FriendApp {
	public static void main(String[] args) {
		// 친구.
		Friend frnd = new Friend();
		frnd.setName("홍길동");
		frnd.setPhone("010-1111-2222");

		UnivFriend univFrnd = new UnivFriend("김민규", "010-3333-4444", "대구대학교", "역사학과");
		ComFriend comFrnd = new ComFriend("유재석", "010-5555-6666", "MBC", "미디어");
		
		Friend[] friends = new Friend[5]; // 부모클래스의 참조값을 담도록 배열.
		friends[0] = frnd;
		friends[1] = univFrnd;
		friends[2] = comFrnd;
		
		for(Friend friend : friends ) {
			if(friend != null)
			System.out.println(friend.showInfo());
		}
	}
}
