function DeleteFunction(id) {
	if (confirm("delete?")) {
		fetch("./delete/" + id)
		.then(() => {
			location.reload()
		})
	}
}