package spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// ȸ�� �����͸� �����ϴ� DB ��ü�� Class
public class MemberDao
{
	private static long nextId = 0;
	
	private Map<String, Member> map = new HashMap<String, Member>();
	
	// �Է��� �̸��� ã��
	public Member selectByEmail(String email)
	{
		return map.get(email);
	}
	
	// �̸��� ����
	public void insert(Member member)
	{
		member.setId(++nextId);
		map.put(member.getEmail(), member);
	}
	
	// �̸��� ����
	public void update(Member member)
	{
		map.put(member.getEmail(), member);
	}
	
	// ��ü ����Ʈ ���
	public Collection<Member> selectAll()
	{
		return map.values();
	}
}

// ȸ�� �������� ���� ��ȸ�� ���� MemberDao�� Cache�� ������ ������ Class
class CachedMemberDao extends MemberDao
{
	// TODO
}