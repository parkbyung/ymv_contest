package org.log5j.ymv.model.voluntary;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDAOImpl implements MessageDAO{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void sendMessageApplicate(MessageVO messageVO) {
		sqlSessionTemplate.insert("message.sendMessageApplicate",messageVO);
	}

}
