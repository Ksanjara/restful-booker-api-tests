# Automated API tests for [Restful-Booker](https://restful-booker.herokuapp.com/) service

## :page_with_curl: Content:

- <a href="#tools"> Instruments used</a>
- <a href="#checking"> Test cases</a>
- <a href="#console"> How to run tests using command line</a>
- <a href="#jenkins"> Jenkins build</a>
- <a href="#report"> Allure report</a>
- <a href="#testops"> Integration with Allure TestOps</a>
- <a href="#jira"> Integration with Jira</a>
- <a href="#tg"> Telegram notifications using chat bot</a>
---

<a id="tools"></a>
## 🔨 Instruments used:


| Java                                                                                                    | IntelliJ  <br>  Idea                                                                                                      | GitHub                                                                                                    | JUnit 5                                                                                                          | Gradle                                                                                                    | Rest Assured                                                                                                               | Allure <br> Report                                                                                                               | Jenkins                                                                                                         | Telegram                                                                                                           |
|:--------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------|
| <a href="https://www.java.com/"><img src="media/logo/Java.svg" width="50" height="50"  alt="Java"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="media/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a> | <a href="https://github.com/"><img src="media/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a> | <a href="https://junit.org/junit5/"><img src="media/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a> | <a href="https://gradle.org/"><img src="media/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a> | <a href="https://rest-assured.io/"><img src="media/logo/Rest-Assured.svg" width="50" height="50"  alt="Rest Assured"/></a> | <a href="https://github.com/allure-framework"><img src="media/logo/Allure_Report.svg" width="50" height="50"  alt="Allure"/></a> | <a href="https://www.jenkins.io/"><img src="media/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a> | <a href="https://web.telegram.org/"><img src="media/logo/Telegram.svg" width="50" height="50" alt="Telegram"/></a> |

Autotests are created using `Java` programming language with plugins: `JUnit 5`, `Selenide`, `Rest-Assured`. Project builder - `Gradle`. For remote build job in `Jenkins` created with creating `Allure Report` at the end of the testing run.
After all tests when Allure Report is ready there are `Telegram notifications` using chat bot realized. 


---

<a id="checking"></a>
## :male_detective:: Test Cases

- ✓ Create successful booking
- ✓ Update tourist name
- ✓ Update total price
- ✓ Update all booking info
- ✓ Delete booking successfully


<a id="console"></a>
### :compass: How to run tests using command line
`gradle clean test -Dlogin=admin -Dpassword=password123`


---

<a id="jenkins"></a>
## <img src="media/logo/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a> <a target="_blank" href="https://jenkins.autotests.cloud/job/C31-ksanjara-java_23_diploma-api-tests/"> Jenkins</a> build
To run this test through Jenkins, please use this [job](https://jenkins.autotests.cloud/job/C31-ksanjara-java_23_diploma-api-tests/), specially created for this project.
To run it please use `Build with Parameters` button, default credentials are set.
You can see the results via Allure Reports by clicking on Allure icon near build.

<p align="center">
<img src="media/screens/Jenkins_api.png" alt="Allure report" >
</p>

---
<a id="report"></a>
## <img src="media/logo/Allure_Report.svg" width="25" height="25"/> [Allure](https://jenkins.autotests.cloud/job/C31-ksanjara-java_23_diploma-api-tests/) Report

### 🖨️ Report main page

<p align="center">
<img src="media/screens/Allure_report_main_api.png" alt="Allure report">
</p>

### 📄 Test cases page

<p align="center">
<img src="media/screens/Allure_report_cases_api.png" alt="Test Case">
</p>

---
<a id="testops"></a>
## <img src="media/logo/AllureTestOps.svg" width="25" height="25"/> Integration with [Allure TestOps](https://allure.autotests.cloud/project/4635/test-cases?treeId=0)

### 🖨️ Dashboard page
<p align="center">
<img src="media/screens/Allure_dasboard.png" alt="Allure testOps">
</p>

### 📄 Test cases page
<p align="center">
<img src="media/screens/Allure_cases.png" alt="Allure test cases">
</p>

---
<a id="jira"></a>
## <img src="media/logo/Jira.svg" width="25" height="25"/> Integration with [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1402)

### Jira task with Allure TestOps integration
<p align="center">
<img src="media/screens/Jira.png" alt="Jira task">
</p>

---

<a id="tg"></a>
## <img src="media/logo/Telegram.svg" width="25" height="25"/> Telegram notifications



### Notification example in telegram channel

<p align="center">
<img src="media/screens/Telegram_notif_api.png" alt="Telegram notification">
</p>


#### Telegram notification contains:

- :heavy_check_mark: Environment
- :heavy_check_mark: Comment
- :heavy_check_mark: Duration
- :heavy_check_mark: Total scenarios
- :heavy_check_mark: Total passed tests
- :heavy_check_mark: Total failed tests
- :heavy_check_mark: Total broken tests
- :heavy_check_mark: Allure Report link

---