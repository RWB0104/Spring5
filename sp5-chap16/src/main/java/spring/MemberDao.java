package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MemberDao
{
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Member> memRowMapper = new RowMapper<Member>()
	{
		@Override
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			Member member = new Member(rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("NAME"), rs.getTimestamp("REGDATE").toLocalDateTime());
			member.setId(rs.getLong("ID"));
			
			return member;
		}
	};
	
	public MemberDao(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insert(Member member)
	{
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator()
		{
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException
			{
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO `MEMBER` (EMAIL, PASSWORD, NAME, REGDATE) VALUES (?, ?, ?, ?)", new String[] { "ID" });
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
				
				return pstmt;
			}
		}, keyHolder);
		
		Number keyValue = keyHolder.getKey();
		
		member.setId(keyValue.longValue());
	}
	
	public void update(Member member)
	{
		jdbcTemplate.update("UPDATE `MEMBER` SET NAME = ?, PASSWORD = ? WHERE EMAIL = ?", member.getName(), member.getPassword(), member.getEmail());
	}
	
	public int count()
	{
		Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM `MEMBER`", Integer.class);
		
		return count;
	}
	
	public Member selectByEmail(String email)
	{
		List<Member> results = jdbcTemplate.query("SELECT * FROM `MEMBER` WHERE EMAIL = ?", memRowMapper, email);
		
		return results.isEmpty() ? null : results.get(0);
	}
	
	public List<Member> selectAll()
	{
		List<Member> results = jdbcTemplate.query("SELECT * FROM `MEMBER`", memRowMapper);
		
		return results;
	}
	
	public List<Member> selectByRegidate(LocalDateTime from, LocalDateTime to)
	{
		List<Member> results = jdbcTemplate.query("SELECT * FROM `MEMBER` WHERE REGDATE BETWEEN ? AND ? ORDER BY REGDATE DESC", memRowMapper, from, to);
		
		return results;
	}
	
	public Member selectById(Long memId)
	{
		List<Member> results = jdbcTemplate.query("SELECT * FROM `MEMBER` WHERE ID = ?", memRowMapper, memId);
		
		return results.isEmpty() ? null : results.get(0);
	}
}