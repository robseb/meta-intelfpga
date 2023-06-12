## Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2023

SUMMARY = "Linux Kernel 5.15.80 LTS for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 5.15.80 LTS for Intel PSG (ALTERA) SoC-FPGAs" 


LINUX_VERSION = "5.15.80"
LINUX_VERSION_SUFFIX = "-lts"

# Note: Wed Jan 25 14:07:00 2023 -0600
SRCREV = "dacc5e3eb584327cf008331e91f80a875a5af908"
SRCREV:machine:cyclone5 ?= "dacc5e3eb584327cf008331e91f80a875a5af908"
include linux-altera.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/config:"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

SRC_URI:append_cyclone5 = " file://lbdaf.scc "
SRC_URI:append_arria5 = " file://lbdaf.scc "
SRC_URI:append_arria10 = " file://lbdaf.scc "


do_install[depends] += "virtual/kernel:do_shared_workdir"