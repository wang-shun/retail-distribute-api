@echo off

rem -- Lipsion
color 1f
:menu
echo   ________________________________________________________________
echo  ^|                                                                ^|
echo  ^|                     Maven  -  �������                         ^|
echo  ^|                                                                ^|
echo  ^|  0 - clean package -D...skip=true -Pwindows                    ^|
echo  ^|  1 - clean package -D...skip=true -Punix                       ^|
echo  ^|________________________________________________________________^|
:input
set /p input=-^> ��ѡ��������: 

if "%input%"== "0" goto windows
if "%input%"== "1" goto unix
goto end

:windows
echo  # ����Windows������ #
mvn clean package -Dmaven.test.skip=true -Pwindows&&pause&&cls&& call compile.bat

:unix
echo  # ����Unix������ #
mvn clean package -Dmaven.test.skip=true -Punix&&pause&&cls&& call compile.bat


rem for /d %%d in (*) do (
rem  if exist %%d\POM.xml set dao_dir=%%d
rem )
rem echo ��ǰĿ¼��:%dao_dir%
rem &&pause 
:end
echo ����
prompt
popd