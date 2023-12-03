package umc.blue.converter;

import umc.blue.domain.Food;
import umc.blue.domain.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPreferList(List<Food> foodList) {
        return foodList.stream()
                .map(food -> {
                    return MemberPrefer.builder()
                            .food(food)
                            .build();
                }).collect(Collectors.toList());
    }
}
