LINUX_VERSION = "5.10"

# Note: Sat Jan 30 14:08:59 2021 -0600
SRCREV = "f7700e50b1d0fedadecefc75f3aa4d36c28d0a56"

include linux-altera.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://lbdaf.scc "
SRC_URI_append_arria5 = " file://lbdaf.scc   "
SRC_URI_append_arria10 = " file://lbdaf.scc "
