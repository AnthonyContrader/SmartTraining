package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.GroupDTO;
import it.contrader.model.Group;

public class GroupConverter implements Converter<Group, GroupDTO>{

	@Override
	public GroupDTO toDTO(Group group) {
		// TODO Auto-generated method stub
		GroupDTO groupDTO = new GroupDTO(group.getId(), group.getIdStudent());
		return groupDTO;
	}

	@Override
	public Group toEntity(GroupDTO groupDTO) {
		// TODO Auto-generated method stub
		Group group = new Group(groupDTO.getId(), groupDTO.getIdStudent());
		return group;
	}

	@Override
	public List<GroupDTO> toDTOList(List<Group> groupList) {
		// TODO Auto-generated method stub
		List<GroupDTO> groupDTOList = new ArrayList<GroupDTO>();
		for(Group group: groupList) {
			groupDTOList.add(toDTO(group));
		}
		return groupDTOList;
	}

}
