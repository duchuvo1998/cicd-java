#!/bin/bash

PID=$(pgrep -f "java -jar demo-cicd-0.0.1-SNAPSHOT.jar")

if [ -z "$PID" ]; then
    echo "Not Running."
else
    echo "Stop PID: $PID"
    kill -9 $PID
    sleep 5
fi

# Bắt đầu ứng dụng mới
echo "Start app..."
nohup java -jar ./build/libs/demo-cicd-0.0.1-SNAPSHOT.jar >/dev/null 2>&1 &
echo "Stated."
