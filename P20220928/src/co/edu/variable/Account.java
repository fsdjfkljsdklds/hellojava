package co.edu.variable;

public class Account {

 String accNo; // 계좌번호. 두 단어의 조합 : 2번째 첫번째 대문자.
 String Owner; // 예금주.
 int balance; // 예금액.
	
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getOwner() {
		return Owner;
	}
	public void setOwner(String owner) {
		Owner = owner;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}


	
	
}
