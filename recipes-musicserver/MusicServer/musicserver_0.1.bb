# Derived from Hello World example recipe

DESCRIPTION = "Music server for raspberry pi"
SECTION = "media"
DEPENDS += " libao"
RDEPENDS_${PN} = "libao glibc"
LICENSE = "NONE"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4c0adec6a9e9d37fddde09a27dd0151c"

SRCREV = "975acc64f006d8ca29ae7dd36cd5270926f80044"
SRC_URI = "git://github.com/10tpell/MusicServer.git \
           "

FILES_${PN} += "/home/root/MusicServer /home/root/MusicServer/*"

S = "${WORKDIR}/git"

inherit pkgconfig cmake

do_install() {
  install -d ${D}/home/root/MusicServer
  cp -r ${S}/resources ${D}/home/root/MusicServer
  install -d ${D}${bindir}
  install -m 0755 MusicServer ${D}${bindir}
}