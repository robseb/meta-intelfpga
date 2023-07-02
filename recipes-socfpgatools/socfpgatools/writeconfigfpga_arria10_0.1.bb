# Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2023

SUMMARY = "Tool to load a new FPGA Configuration for Intel SoC-FPGAs"
DESCRIPTION = "Tool to change via the Intel FPGA Manger the FPGA configuration of a Intel SoC-FPGA"  

SECTION = "rstools" 
LICENSE = "MIT"
PR = "r0"
LIC_FILES_CHKSUM = "file://CHECKSUMFILE;md5=bff2b7959c4b3958a8ae19f6a39a59ac"
SRC_URI = "gitsm://github.com/robseb/rstoolsA10.git;protocol=https"
SRCREV = "${AUTOREV}" 
# use  git rev-parse HEAD to update

# This Version is for the Intel Arria 10 SoC-FPGA
COMPATIBLE_MACHINE = 'arria10'

inherit cmake

S = "${WORKDIR}/git/FPGA-writeConfig"
FILES_${PN} += "${bindir}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 FPGA-writeConfig ${D}${bindir}
}
