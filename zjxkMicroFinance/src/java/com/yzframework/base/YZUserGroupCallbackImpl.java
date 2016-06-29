package com.yzframework.base;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jbpm.task.identity.UserGroupCallback;

import com.yzframework.model.Tuserrole;
import com.yzframework.service.JbpmService;

public class YZUserGroupCallbackImpl implements UserGroupCallback {

	private Map<String, Set<String>> groupStore;
	private Set<String> allgroups;

	private JbpmService jbpmService;

	public void setjbpmService(JbpmService jbpmService) {
		this.jbpmService = jbpmService;
	}

	@Override
	public boolean existsGroup(String groupId) {
		return allgroups.contains(groupId);
	}

	@Override
	public boolean existsUser(String userId) {
		return groupStore.containsKey(userId);
	}

	@Override
	public List<String> getGroupsForUser(String userId, List<String> groupIds, List<String> allExistingGroupIds) {
		if (groupStore.get(userId) == null) {
			List<String> emptyList = Collections.emptyList();
			return emptyList;
		}
		String[] array = groupStore.get(userId).toArray(new String[0]);
		return Arrays.asList(array);
	}

	protected void init() throws Exception {
		groupStore = new HashMap<String, Set<String>>();
		allgroups = new HashSet<String>();

		List<Tuserrole> list = jbpmService.findUserAndRole();
		for (Tuserrole tUserRole : list) {
			String userId = (String) tUserRole.getUserid();
			String roleId = (String) tUserRole.getRoleid();
			addUserToRole(userId, roleId);
			addRole(roleId);
		}

		if (!groupStore.containsKey("Administrator")) {
			Set<String> emptySet = Collections.emptySet();
			groupStore.put("Administrator", emptySet);
		}
	}

	public void addUserToRole(String userId, String roleId) {
		if (groupStore.containsKey(userId)) {
			groupStore.get(userId).add(roleId);
		} else {
			HashSet<String> groupSet = new HashSet<String>();
			groupSet.add(roleId);
			groupStore.put(userId, groupSet);
		}
	}

	public void removeUserFromRole(String userId, String roleId) {
		if (groupStore.containsKey(userId)) {
			groupStore.get(userId).remove(roleId);
		}
	}

	public void addRole(String roleId) {
		allgroups.add(roleId);
	}

	public void removeRole(String roleId) {
		allgroups.remove(roleId);
	}
}
