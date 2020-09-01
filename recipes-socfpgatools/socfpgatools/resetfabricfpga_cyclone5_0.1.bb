# Robin Sebastian (https://github.com/robseb) 2019-2020
SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "rstools application to delate the FPGA Fabric configuration with the FPGA manager" 
SECTION = "rstools" 
LICENSE = "GPL-2"
PR = "r0"
LIC_FILES_CHKSUM = "file://CHECKSUMFILE;md5=bff2b7959c4b3958a8ae19f6a39a59ac"
SRC_URI = "gitsm://github.com/robseb/rstoolsCY5.git;protocol=https"
SRCREV = "${AUTOREV}"
# use  git rev-parse HEAD to update

# This Version is for the Intel Cyclone V SoC-FPGA
COMPATIBLE_MACHINE = 'cyclone5'


inherit cmake

S = "${WORKDIR}/git/FPGA-resetFabric"
FILES_${PN} += "${bindir}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 FPGA-resetFabric ${D}${bindir}
}
