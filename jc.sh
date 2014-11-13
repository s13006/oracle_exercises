#!/bin/sh

# 各自の環境に合わせて記述
CLASSPATH=/home/s13006/instantclient_12_1/ojdbc7.jar:.

export CLASSPATH
javac  $1
