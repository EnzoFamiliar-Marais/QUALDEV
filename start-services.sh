#!/bin/bash

# When CTRL+C is pressed → kill all background jobs
cleanup() {
    echo ""
    echo "Stopping all services..."
    kill $(jobs -p)
    exit 0
}

trap cleanup INT

echo "Starting Product Registry Domain Service..."
gradle -Dorg.gradle.jvmargs=-Xmx200m :apps:product-registry-domain-service:quarkusDev &
PID1=$!

echo "Starting Product Registry Read Service..."
gradle -Dorg.gradle.jvmargs=-Xmx200m :apps:product-registry-read-service:quarkusDev &
PID2=$!

echo "Starting Store Back..."
gradle -Dorg.gradle.jvmargs=-Xmx200m :apps:store-back:quarkusDev &
PID3=$!

echo "Starting Store Front..."
pnpm run --filter apps-store-front start &
PID4=$!

echo "All services started."
echo "Press CTRL+C to stop everything."

# Wait for all processes
wait $PID1 $PID2 $PID3 $PID4

## fin du fichiers start-services.sh
