#
## rsyocto GmbH & Co. KG * Robin Sebastian (git@robseb.de)
#

SUMMARY = "ARM Development Studio (DS-5) Streamline Gator daemon"
DESCRIPTION = "Server application for using the ARM Development Studio (DS-5) Streamline for performance analysis"
LICENSE = "GPL-2.0-only"

LIC_FILES_CHKSUM = "file://dco.txt;md5=e59ab8d56e1112527e696ad021bf5faf"

# Use the gator version 8.6.0 (JUN-2023)
SRCREV = "a22c0ee3c2049efe5c5999020557cf0f307dbb06" 

SRC_URI = "git://github.com/ARM-software/gator.git;protocol=http;branch=main \
           file://gator.init"

# Require Linux shell script tools 
inherit update-rc.d

# This Version has only ARMv7-A (32-Bit) support 
COMPATIBLE_MACHINE = '(cyclone5|arria5|arria10)'

S = "${WORKDIR}/git"
PV = "git${SRCPV}"

# To avoid bitbake stried issues
INSANE_SKIP_${PN} = "ldflags"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"


LDFLAGS=''
CCLD = "${CXX}"

EXTRA_OEMAKE = "'CFLAGS=${CFLAGS} ${TARGET_CC_ARCH} -D_DEFAULT_SOURCE -DETCDIR=\"${sysconfdir}\"' \
    'LDFLAGS=${LDFLAGS} ${TARGET_CC_ARCH}' 'CROSS_COMPILE=${TARGET_PREFIX}' \
    'CXXFLAGS=${CXXFLAGS} ${TARGET_CC_ARCH} -fno-rtti'"


do_compile() {
  # Build gator 
  oe_runmake -C daemon CC='${CC}' CXX='${CXX}'
  #oe_runmake -C daemon CROSS_COMPILE=${TARGET_PREFIX} CC='${CC}' CXX='${CXX}'
}

do_install() {
  install -D -p -m0755 daemon/gatord ${D}/${sbindir}/gatord
  install -D -p -m0755 ${WORKDIR}/gator.init ${D}/${sysconfdir}/init.d/gator
}

INITSCRIPT_NAME = "gator"
INITSCRIPT_PARAMS = "defaults 66"
