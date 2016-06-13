@echo off

rem -- Lipsion
color 1f
:menu
echo   ________________________________________________________________
echo  ^|                                                                ^|
echo  ^|                     Maven  -  �������                         ^|
echo  ^|                                                                ^|
echo  ^|  0 - eclipse:clean clean       1 - clean package -D...skip=true^|
echo  ^|  2 - eclipse:e.. -Ddown..      3 - package -D...skip=true      ^|
echo  ^|      -Dwtp..                                                   ^|
echo  ^|  4 - ���벿���                5 - mvn jetty:run               ^|
echo  ^|  6 - mvn deploy                7 - mvn install                 ^|
echo  ^|  8 - �޸�maven���̰汾��                                       ^|
echo  ^|________________________________________________________________^|
:input
set /p input=-^> ��ѡ��: 

if "%input%"== "0" goto clean
if "%input%"== "1" goto clean-package
if "%input%"== "2" goto eclipse
if "%input%"== "3" goto package
if "%input%"== "4" goto deploy-zip
if "%input%"== "5" goto jetty-run
if "%input%"== "6" goto deploy
if "%input%"== "7" goto install
if "%input%"== "8" goto change-version
goto end

:clean
echo  # �������̱��� #
mvn eclipse:clean clean&&pause&&cls&& call compile.bat

:clean-package
echo  # �������벢��� #
mvn clean package -Dmaven.test.skip=true &&pause&&cls&& call compile.bat

:eclipse
echo  # ת��Eclipse���� #
mvn eclipse:clean eclipse:eclipse -DdownloadSources=true &&pause&&cls&& call compile.bat

:package
echo  # ��� #
mvn package -Dmaven.test.skip=true &&pause&&cls&& call compile.bat

:change-version
echo  #  ��������Ҫ�����İ汾 #
set /p newVersion=
echo # ���̰汾%newVersion% #
call mvn clean versions:set -DnewVersion=%newVersion%
echo # �����Ƿ�������ģ�鶼�����汾�ɹ� �°汾Ϊ%newVersion% #
echo # ��ʼɾ��pom.xml.versionsBackup�ļ� #
del  /s  pom.xml.versionsBackup
pause&&cls&& call compile.bat

:deploy-zip
cls && call deploy.bat
:jetty-run
rem start mvn jetty:run
for /d %%d in (*) do (
  rem if exist %%d\POM.xml set web_dir=%%d
  if %%d:~-5%=="web" goto run-mvn-jetty
)

:run-mvn-jetty
cd %%d&start mvn jetty:run

:deploy
echo  # ���� #
mvn deploy -Dmaven.test.skip=true &&pause&&cls&& call compile.bat

:install
echo  # ��װ���زֿ� #
mvn install -Dmaven.test.skip=true &&pause&&cls&& call compile.bat

rem for /d %%d in (*) do (
rem  if exist %%d\POM.xml set dao_dir=%%d
rem )
rem echo ��ǰĿ¼��:%dao_dir%
rem &&pause 
:end
echo ����
prompt
popd