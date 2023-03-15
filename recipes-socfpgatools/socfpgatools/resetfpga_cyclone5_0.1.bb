# Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2023

SUMMARY = "Reset the FPGA Fabric"
DESCRIPTION = "Tool to remove via the Intel FPGA Manager the FPGA Fabric configuration by putting it to reset" 
SECTION = "rstools" 
LICENSE = "GPL-2"
PR = "r0"
BRANCH ="main"
LIC_FILES_CHKSUM = "file://CHECKSUMFILE;md5=bff2b7959c4b3958a8ae19f6a39a59ac"
SRC_URI = "gitsm://github.com/robseb/rstools.git;protocol=https;branch=${BRANCH}"
SRCREV = "${AUTOREV}"
# use  git rev-parse HEAD to update

# This Version is for the Intel Cyclone V SoC-FPGA
COMPATIBLE_MACHINE = 'cyclone5'


inherit cmake

S = "${WORKDIR}/git/FPGA-reset"
FILES_${PN} += "${bindir}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 FPGA-reset ${D}${bindir}
}
