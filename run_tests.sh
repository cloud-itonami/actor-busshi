#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")"
for suite in test/busshi/methods/*_test.cljc; do
  echo "== $suite =="
  bb "$suite"
done
