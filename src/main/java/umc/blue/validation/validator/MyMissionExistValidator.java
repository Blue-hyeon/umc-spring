package umc.blue.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.blue.apiPayload.code.status.ErrorStatus;
import umc.blue.repository.MyMissionRepository;
import umc.blue.validation.annotation.ExistMyMission;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class MyMissionExistValidator implements ConstraintValidator<ExistMyMission, Long> {
    private final MyMissionRepository myMissionRepository;

    @Override
    public void initialize(ExistMyMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = myMissionRepository.existsById(value);

        if (isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MY_MISSION_IS_EXIST.toString()).addConstraintViolation();
        }

        return !isValid;
    }
}
