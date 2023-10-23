## Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2023

SUMMARY = "Linux Kernel 5.15.90 LTS for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 5.15.90 LTS for Intel PSG (ALTERA) SoC-FPGAs" 


LINUX_VERSION = "5.15.90"
LINUX_VERSION_SUFFIX = "-lts"

# Date:   Fri Mar 31 10:12:50 2023 +0800
SRCREV = "0b11acba1131c487de5c795abca96f132006486a"
SRCREV:machine:cyclone5 ?= "0b11acba1131c487de5c795abca96f132006486a"

include linux-altera.inc


LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

