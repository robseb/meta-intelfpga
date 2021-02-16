LINUX_VERSION = "5.4.84"
LINUX_VERSION_SUFFIX = "-lts"

SRCREV = "495c4b3595bb150b7a8320c89501ae7b33576898"

include linux-altera.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

SRC_URI_append_cyclone5 = " file://lbdaf.scc "
SRC_URI_append_arria5 = " file://lbdaf.scc "
SRC_URI_append_arria10 = " file://lbdaf.scc "

