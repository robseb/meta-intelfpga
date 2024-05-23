## rsyocto GmbH & Co. KG * Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2024

SUMMARY = "Linux Kernel 6.6 for Intel (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 6.6 for Intel (ALTERA) SoC-FPGAs" 

LINUX_VERSION ?= "6.6"

# Note: Date:   Fri Nov 17 08:13:36 2023 -0500
SRCREV = "9885eb35dc56d481c8152423875776be220cb541"
SRCREV:machine:cyclone5 ?= "9885eb35dc56d481c8152423875776be220cb541"

include linux-altera.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

FILESEXTRAPATHS:prepend := "${THISDIR}/config:"

