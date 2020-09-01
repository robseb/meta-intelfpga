# Robin Sebastian (https://github.com/robseb) 2019-2020
SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "rstools application to read the FPGA MSEL Switch with the FPGA Manager (A10)" 
SECTION = "rstools" 
LICENSE = "GPL-2"
PR = "r0" 
LIC_FILES_CHKSUM = "file://CHECKSUMFILE;md5=bff2b7959c4b3958a8ae19f6a39a59ac"
SRC_URI = "gitsm://github.com/robseb/rstoolsA10.git;protocol=https"

# This Version is for the Intel Arria 10 SoC-FPGA
COMPATIBLE_MACHINE = 'arria10'


SRCREV = "${AUTOREV}"
# use  git rev-parse HEAD to update

inherit cmake

S = "${WORKDIR}/git/FPGA-readMSEL"
FILES_${PN} += "${bindir}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 FPGA-readMSEL ${D}${bindir}
}


