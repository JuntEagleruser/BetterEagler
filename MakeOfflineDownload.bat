@echo off
title MakeOfflineDownload
java -cp "desktopRuntime/MakeOfflineDownload.jar;desktopRuntime/CompileEPK.jar" net.lax1dude.eaglercraft.v1_8.buildtools.workspace.MakeOfflineDownload "javascript/OfflineDownloadTemplate.txt" "javascript/classes.js" "javascript/assets.epk" "javascript/EaglerForge_v1.3_1.8_Offline_en_US.html" "javascript/EaglerForge_v1.3_1.8_Offline_International.html" "javascript/lang"
pause