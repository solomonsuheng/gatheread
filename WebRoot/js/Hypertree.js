var labelType, useGradients, nativeTextSupport, animate;

(function() {
	var ua = navigator.userAgent, iStuff = ua.match(/iPhone/i)
			|| ua.match(/iPad/i), typeOfCanvas = typeof HTMLCanvasElement, nativeCanvasSupport = (typeOfCanvas == 'object' || typeOfCanvas == 'function'), textSupport = nativeCanvasSupport
			&& (typeof document.createElement('canvas').getContext('2d').fillText == 'function');
	// I'm setting this based on the fact that ExCanvas provides text support
	// for IE
	// and that as of today iPhone/iPad current text support is lame
	labelType = (!nativeCanvasSupport || (textSupport && !iStuff)) ? 'Native'
			: 'HTML';
	nativeTextSupport = labelType == 'Native';
	useGradients = nativeCanvasSupport;
	animate = !(iStuff || !nativeCanvasSupport);
})();

var Log = {
	elem : false,
	write : function(text) {
		if (!this.elem)
			this.elem = document.getElementById('log');
		this.elem.innerHTML = text;
		this.elem.style.left = (500 - this.elem.offsetWidth / 2) + 'px';
	}
};

function init() {
	// init data
	var json = {
		"id" : "1",
		"name" : "聚读",
		"children" : [ {
			"id" : "1.1",
			"name" : "汤森路透",
			"children" : [ {
				"id" : "1.1.1",
				"name" : "亚洲证券业",
				"data" : {
					"band" : "汤森路透",
					"relation" : "member of band"
				}
			}, {
				"id" : "1.1.2",
				"name" : "亚洲证券业",
				"data" : {
					"band" : "金融市场",
					"relation" : "member of band"
				}
			} ],
			"data" : {
				"band" : "聚读",
				"relation" : "member of band"
			}
		}, {
			"id" : "1.2",
			"name" : "新华社",
			"data" : {
				"band" : "聚读",
				"relation" : "member of band"
			}
		}, {
			"id" : "1.3",
			"name" : "新周刊",
			"children" : [ {
				"id" : "1.3.1",
				"name" : "我们更需要莎士比亚",
				"data" : {
					"band" : "新周刊",
					"relation" : "member of band"
				}
			}, {
				"id" : "1.3.2",
				"name" : "纽约客",
				"data" : {
					"band" : "新周刊",
					"relation" : "member of band"
				}
			}, {
				"id" : "1.3.3",
				"name" : "二次元的领导人",
				"data" : {
					"band" : "新周刊",
					"relation" : "member of band"
				}
			} ],
			"data" : {
				"band" : "聚读",
				"relation" : "member of band"
			}
		}

		],
		"data" : []
	};
	// end
	var infovis = document.getElementById('infovis');
	var w = infovis.offsetWidth - 50, h = infovis.offsetHeight - 50;

	// init Hypertree
	var ht = new $jit.Hypertree(
			{
				// id of the visualization container
				injectInto : 'infovis',
				// canvas width and height
				width : w,
				height : h,
				// Change node and edge styles such as
				// color, width and dimensions.
				Node : {
					dim : 7,
					color : "#B22222"
				},
				Edge : {
					lineWidth : 1,
					color : "#8B8989"
				},
				onBeforeCompute : function(node) {
					Log.write("");
				},
				// Attach event handlers and add text to the
				// labels. This method is only triggered on label
				// creation
				onCreateLabel : function(domElement, node) {
					domElement.innerHTML = node.name;
					$jit.util.addEvent(domElement, 'click', function() {
						ht.onClick(node.id, {
							onComplete : function() {
								ht.controller.onComplete();
							}
						});
					});
				},
				// Change node styles when labels are placed
				// or moved.
				onPlaceLabel : function(domElement, node) {
					var style = domElement.style;
					style.display = '';
					style.cursor = 'pointer';
					if (node._depth <= 1) {
						style.fontSize = "1.0em";
						style.color = "#8E388E";

					} else if (node._depth == 2) {
						style.fontSize = "0.7em";
						style.color = "#9AC0CD";

					} else {
						style.display = 'none';
					}

					var left = parseInt(style.left);
					var w = domElement.offsetWidth;
					style.left = (left - w / 2) + 'px';
				},

				onComplete : function() {
					Log.write("");

					// Build the right column relations list.
					// This is done by collecting the information (stored in the
					// data property)
					// for all the nodes adjacent to the centered node.
					var node = ht.graph.getClosestNodeToOrigin("current");
					var html = "<h4>" + node.name + "</h4><b>Connections:</b>";
					html += "<ul>";
					node
							.eachAdjacency(function(adj) {
								var child = adj.nodeTo;
								if (child.data) {
									var rel = (child.data.band == node.name) ? child.data.relation
											: node.data.relation;
									html += "<li>"
											+ child.name
											+ " "
											+ "<div class=\"relation\">(relation: "
											+ rel + ")</div></li>";
								}
							});
					html += "</ul>";
					$jit.id('inner-details').innerHTML = html;
				}
			});
	// load JSON data.
	ht.loadJSON(json);
	// compute positions and plot.
	ht.refresh();
	// end
	ht.controller.onComplete();
}
