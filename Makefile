help: # Display help
	@awk -F ':|##' \
		'/^[^\t].+?:.*?##/ {\
			printf "\033[36m%-30s\033[0m %s\n", $$1, $$NF \
		}' $(MAKEFILE_LIST) | sort

test: ## Run tests.
	@mvn clean verify

docker: ## Run tests on docker containers
	@docker-compose up --build

docker-clean: ## Remove exited containers
	@docker-compose down

.PHONY: docker test