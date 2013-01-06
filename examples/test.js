
var w = createWindow();
w.setTitle("hello");
w.setSize(500,200);
w.show();
w.setFlowLayout();
b = createButton("click me !");
b.onClick(function(e) {
	w.showMessage("hi" + t.getText() );
});

t = createTextField();
w.add(t);
w.add(b);
