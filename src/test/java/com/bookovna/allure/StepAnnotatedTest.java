package com.bookovna.allure;

import com.bookovna.allure.steps.WebSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StepAnnotatedTest {

    private static final String ALLURE_REPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUE_NUMBER = 68;

    private WebSteps steps = new WebSteps();

    @Test
    @DisplayName("Найти Issue в репозитории " + ALLURE_REPOSITORY)
    public void testGithub() {
        steps.openGitMainPage();
        steps.searchForRepository(ALLURE_REPOSITORY);
        steps.goToRepository(ALLURE_REPOSITORY);
        steps.openIssueTab();
        steps.findIssueWithNumber(ISSUE_NUMBER);
    }
}
