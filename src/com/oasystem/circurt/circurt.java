package com.oasystem.circurt;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

import com.oasystem.pojo.TUser;

/**
 * ���̱�������
 * 
 * @author zhaoqx
 * 
 */
public class circurt {
	ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();

	/**
	 * �������̶���
	 */
	@Test
	public void test1() {
		DeploymentBuilder deploymentBuilder = pe.getRepositoryService()
				.createDeployment();
		deploymentBuilder
				.addClasspathResource("com/oasystem/liucheng/FileApply.bpmn");
		deploymentBuilder
				.addClasspathResource("com/oasystem/liucheng/FileApply.png");
		Deployment deployment = deploymentBuilder.deploy();
		System.out.println(deployment.getId());
	}

	/**
	 * �������̱�������������ʵ��ʱ����
	 */
	@Test
	public void test2() {
		String processDefinitionKey = "qjlc";// ���̶���key
		Map<String, Object> variables = new HashMap<>();
		variables.put("key1", "value1");
		variables.put("k2", "v2");
		ProcessInstance pi = pe.getRuntimeService().startProcessInstanceByKey(
				processDefinitionKey, variables);
		System.out.println(pi.getId());
	}
	
	/**
	 * �������̱�������������ʱ���� 
	 */
	@Test
	public void test3() {
		String taskId = "802";
		Map<String, Object> variables = new HashMap<>();
		variables.put("qjts", 3);
		variables.put("qjyy", "�¼�");
		pe.getTaskService().complete(taskId , variables);
	}
	
	/**
	 * �������̱�����ʹ��RuntimeService�ķ�������
	 */
	@Test
	public void test4() {
		String executionId = "201";//����ʵ��ID
		String variableName = "k3";
		Object value = "v3";
		//����һ�����̱���
		pe.getRuntimeService().setVariable(executionId, variableName, value);
		
		Map<String, Object> variables = new HashMap<>();
		variables.put("k4", "v4");
		variables.put("k5", "v5");
		
		TUser user = new TUser();
		user.setId(20);
		user.setcUsername("abc");
		variables.put("user", user);
		//���ö�����̱���
		pe.getRuntimeService().setVariables(executionId, variables );
	}
	
	/**
	 * �������̱�����ʹ��TaskService�ķ�������
	 */
	@Test
	public void test5() {
		String taskId = "304";//����ID
		String variableName = "k6";
		Object value = "v6";
		//����һ�����̱��� 
		pe.getTaskService().setVariable(taskId, variableName, value);
		
		//���ö�����̱��� 
		//pe.getTaskService().setVariables(taskId, variables);
	}
	
	/**
	 * ��ȡ���̱�����ʹ��RuntimeService�ķ���
	 */
	@Test
	public void test6() {
		String executionId = "201";//����ʵ��ID
		String variableName = "key1";
		//��ȡһ�����̱���
		Object value = pe.getRuntimeService().getVariable(executionId , variableName );
		//System.out.println(value);
		
		//��ȡ������̱���
		Map<String, Object> variables = pe.getRuntimeService().getVariables(executionId);
		System.out.println(variables);
	}
	
	/**
	 * ��ȡ���̱�����ʹ��TaskService�ķ���
	 */
	@Test
	public void test7() {
		String taskId = "304";//����ID
		String variableName = "key1";//���̱�����key
		//��ȡһ�����̱���
		Object value = pe.getTaskService().getVariable(taskId, variableName);
		//System.out.println(value);
		
		//��ȡ��ǰ������������ʵ����Χ�����е����̱���
		Map<String, Object> variables = pe.getTaskService().getVariables(taskId);
		System.out.println(variables);
		
	}
}
