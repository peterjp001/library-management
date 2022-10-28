  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
   <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="assets/dist/js/bootstrap.bundle.min.js" ></script>
	<script>
	$(document).ready(function() {
	    var table = $('#example').DataTable( {
	        responsive: true
	    } );
	 
	    new $.fn.dataTable.FixedHeader( table );
	} );
	</script>
    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
  </body>
</html>