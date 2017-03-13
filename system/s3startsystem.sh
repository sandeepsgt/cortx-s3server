#!/bin/sh -xe
# S3 server start script in deployment environment.
#   Usage: s3startsystem.sh <process FID>
#             where process FID: S3 server process FID generated by halon.


if [ $# -ne 1 ]
then
  echo "Invalid number of arguments passed to the script"
  echo "Usage: s3startsystem.sh <process FID>"
  exit 1
fi

ha_config="/etc/sysconfig/s3server-$1"
if [[ ! -r $ha_config ]]
then
  echo "config file '$ha_config' either doesn't exist or not readable"
  exit 1
else
  source $ha_config
fi

# Restart nginx
SERVICE='nginx'
if ps ax | grep -v grep | grep $SERVICE > /dev/null
then
    echo "nginx is running"
else
    systemctl start nginx
fi

# Start the s3server
export PATH=$PATH:/opt/seagate/s3/bin
local_ep=$MERO_S3SERVER_EP
ha_ep=$MERO_HA_EP
profile_fid="<$MERO_PROFILE_FID>"
process_fid="<$MERO_PROCESS_FID>"
s3port=$MERO_S3SERVER_PORT

pid_filename='/var/run/s3server.'$1'.pid'
s3server --s3pidfile $pid_filename \
         --clovislocal $local_ep --clovisha $ha_ep \
         --clovisprofilefid $profile_fid --clovisprocessfid $process_fid \
         --s3port $s3port
