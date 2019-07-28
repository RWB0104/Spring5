package spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// 회원 데이터를 저장하는 DB 대체제 Class
public class MemberDao
{
	private static long nextId = 0;
	
	private Map<String, Member> map = new HashMap<String, Member>();
	
	// 입력한 이메일 찾기
	public Member selectByEmail(String email)
	{
		return map.get(email);
	}
	
	// 이메일 삽입
	public void insert(Member member)
	{
		member.setId(++nextId);
		map.put(member.getEmail(), member);
	}
	
	// 이메일 갱신
	public void update(Member member)
	{
		map.put(member.getEmail(), member);
	}
	
	// 전체 리스트 출력
	public Collection<Member> selectAll()
	{
		return map.values();
	}
}

// 회원 데이터의 빠른 조회를 위해 MemberDao에 Cache를 적용한 가상의 Class
class CachedMemberDao extends MemberDao
{
	// TODO
}