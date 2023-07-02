# Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2023

SUMMARY = "Write to the GPO (general purpose output) register of the Intel FPGA Manager"
DESCRIPTION = "Tool to write via the Intel FPGA Manager the GPO (general purpose output) register that can be read by the FPGA" 
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

S = "${WORKDIR}/git/FPGA-gpoWrite"
FILES_${PN} += "${bindir}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 FPGA-gpoWrite ${D}${bindir}
}
