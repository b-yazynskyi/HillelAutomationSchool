#!/bin/sh -x

if ! docker image inspect gromanas/selenoid_chromium_vnc:112.0 > /dev/null 2>&1; then
  echo "Image gromanas/selenoid_chromium_vnc:112.0 not found. Pulling..."
  docker pull gromanas/selenoid_chromium_vnc:112.0
else
  echo "Image gromanas/selenoid_chromium_vnc:112.0 already exists. Skipping pull."
fi

docker run -d --name selenoid -p 4444:4444 -v /var/run/docker.sock:/var/run/docker.sock -v `pwd`/config/:/etc/selenoid/:ro --privileged aerokube/selenoid:latest-release selenoid start --vnc --args "-limit 10"
docker run -d --name selenoid-ui --link selenoid -p 8080:8080 aerokube/selenoid-ui --selenoid-uri=http://selenoid:4444