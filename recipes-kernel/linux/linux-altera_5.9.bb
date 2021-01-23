LINUX_VERSION = "5.9"

# Note: During development! (Commit from Sun Nov 1 14:02:56 2020)
SRCREV = "f126b6702e7354d6247a36f20b9172457af5c15a"

include linux-altera.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://lbdaf.scc "
SRC_URI_append_arria5 = " file://lbdaf.scc "
SRC_URI_append_arria10 = " file://lbdaf.scc "
