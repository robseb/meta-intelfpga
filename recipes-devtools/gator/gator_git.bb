SUMMARY = "DS-5 Streamline Gator daemon"
DESCRIPTION = "Server task for using ARM DS-5 Streamline for performace analyization"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://daemon/COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

# Use the latest gator version 
SRCREV = "${AUTOREV}" 

SRC_URI = "git://github.com/ARM-software/gator.git;protocol=http;branch=master \
           file://gator.init"

#Require Linux shell script tools 
inherit update-rc.d module

# This Version has only ARMv7-A (32-Bit) support 
COMPATIBLE_MACHINE = '(cyclone5|arria5|arria10)'

S = "${WORKDIR}/git"
PV = "git${SRCPV}"


LDFLAGS=''
INHIBIT_PACKAGE_STRIP  = "1"

do_compile() {
  # Build gator 
  oe_runmake -C daemon CROSS_COMPILE=${TARGET_PREFIX} CC='${CC}' CXX='${CXX}'
}

do_install() {
  install -d ${D}${sbindir}
  install -d ${D}${INIT_D_DIR}
  install -m 0755 ${S}/daemon/gatord  ${D}${sbindir}/gatord
  install -m 0755 ${WORKDIR}/gator.init ${D}${INIT_D_DIR}/gator
}

FILES_${PN} = " \
  ${INIT_D_DIR}/gator \
  ${sbindir}/gatord"

INITSCRIPT_NAME = "gator"
INITSCRIPT_PARAMS = "defaults 66"