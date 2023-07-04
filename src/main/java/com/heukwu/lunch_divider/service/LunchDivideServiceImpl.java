package com.heukwu.lunch_divider.service;

import com.heukwu.lunch_divider.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LunchDivideServiceImpl implements LunchDivideService {
    @Override
    public List<Person> getPeopleList(List<String> names) {
        List<Person> peopleList = new ArrayList<>();
        for (String name : names) {
            peopleList.add(new Person(name));
        }

        return peopleList;
    }

    @Override
    public String divideIntoGroup(List<Person> people, int groupCount) {
        int peopleCount = people.size();
        Collections.shuffle(people);

        int groupSize = peopleCount / groupCount;
        int remain = peopleCount % groupCount;

        StringBuilder sb = new StringBuilder();
        // 표 시작
        sb.append("<table>");

        int start = 0;
        for (int i = 0; i < groupCount; i++) {
            int count = groupSize;
            if (i < remain) {
                count++;
            }

            sb.append("<tr>");
            sb.append("<th>그룹 ").append(i + 1).append("</th>");
            sb.append("</tr>");

            sb.append("<tr>");
            sb.append("<td><ul>");

            for (int j = 0; j < count; j++) {
                sb.append("<li>").append(people.get(start + j)).append("</li>");
            }

            sb.append("</ul></td>");
            sb.append("</tr>");

            start += count;
        }

        // 표 종료
        sb.append("</table>");

        return sb.toString();
    }

}
