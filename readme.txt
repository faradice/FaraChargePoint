wsdl central service for the 1.5 version on digital ocean
wsimport  -Xnocompile -Xendorsed -keep -extension -s src http://104.236.81.197:8088/Ocpp15WebAppDemo/CentralSystemService?wsdl

wsdl chargepoint service for the 1.5 version on digital ocean
wsimport -Xnocompile -Xendorsed -keep -extension -s src wsdl/ocpp_chargepointservice_1.5.wsdl

wsdl chargepoint service for the 1.6 version on digital ocean
wsimport -Xnocompile -Xendorsed -keep -extension -s src wsdl/OCPP_ChargePointService_1.6.wsdl

wsdl central service for the 1.6 version on digital ocean
wsimport -Xnocompile -Xendorsed -keep -extension -s src http://104.236.81.197:8088/cs_ocpp16/CentralSystemService?wsdl

