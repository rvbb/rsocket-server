#need to update
docker build -t b2b/rsocket-server:1.0 .
docker tag b2b/rsocket-server:1.0 apphub.rvbb.vn/b2b/rsocket-server:1.0
docker push apphub.rvbb.vn/b2b2/rsocket-server:1.0
