$(function() {
	// ���Ƚ�#back-to-top����
	$("#totop").hide();
	// ����������λ�ô��ھඥ��100��������ʱ����ת���ӳ��֣�������ʧ
	$(function() {
		$(window).scroll(function() {
			if ($(window).scrollTop() > 100) {
				$("#totop").fadeIn();
			} else {
				$("#totop").fadeOut();
			}
		});
		// �������ת���Ӻ󣬻ص�ҳ�涥��λ��
		$("#totop").click(function() {
			$('body,html').animate({
				scrollTop : 0
			}, 500);
			return false;
		});
	});
});