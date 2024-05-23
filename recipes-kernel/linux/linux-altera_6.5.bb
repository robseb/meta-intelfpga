## rsyocto GmbH & Co. KG * Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2024

SUMMARY = "Linux Kernel 6.5 for Intel (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 6.5 for Intel (ALTERA) SoC-FPGAs" 

LINUX_VERSION ?= "6.5"

# Note: Date:   Sat Sep 9 16:14:34 2023 +0800
SRCREV = "f69b48e838bfa839949c40c0aff80caf08bc24aa"
SRCREV:machine:cyclone5 ?= "f69b48e838bfa839949c40c0aff80caf08bc24aa"

include linux-altera.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

FILESEXTRAPATHS:prepend := "${THISDIR}/config:"

