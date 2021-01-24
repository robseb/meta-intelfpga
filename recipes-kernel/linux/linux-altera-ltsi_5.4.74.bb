LINUX_VERSION = "5.4.74"
LINUX_VERSION_SUFFIX = "-ltsi"

SRCREV = "1c728719a4da6e654afb9cc047164755072ed7c9"

include linux-altera.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

SRC_URI_append_cyclone5 = " file://lbdaf.scc "
SRC_URI_append_arria5 = " file://lbdaf.scc "
SRC_URI_append_arria10 = " file://lbdaf.scc "

