import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableColumn;

public class JFaceExplorer extends ApplicationWindow {
  public JFaceExplorer() {
    super(null);
    addStatusLine();
  }

  protected Control createContents(Composite parent) {
    getShell().setText("JFace File Explorer");
    SashForm sash_form = new SashForm(parent, SWT.HORIZONTAL | SWT.NULL);

    TreeViewer tv = new TreeViewer(sash_form);
    tv.setContentProvider(new FileTreeContentProvider());
    tv.setLabelProvider(new FileTreeLabelProvider());
    tv.setInput(new File("C:\\"));
    tv.addFilter(new AllowOnlyFoldersFilter());

    final TableViewer tbv = new TableViewer(sash_form, SWT.BORDER
        | SWT.FULL_SELECTION | SWT.MULTI);
    tbv.setContentProvider(new FileTableContentProvider());
    tbv.setLabelProvider(new FileTableLabelProvider());
    tbv.setSorter(new FileSorter());

    TableColumn column = new TableColumn(tbv.getTable(), SWT.LEFT);
    column.setText("Name");
    column.setWidth(200);

    column = new TableColumn(tbv.getTable(), SWT.RIGHT);
    column.setText("Size");
    column.setWidth(100);

    tbv.getTable().setHeaderVisible(true);

    tv.addSelectionChangedListener(new ISelectionChangedListener() {
      public void selectionChanged(SelectionChangedEvent event) {
        IStructuredSelection selection = (IStructuredSelection) event
            .getSelection();

        Object selected_file = selection.getFirstElement();
        tbv.setInput(selected_file);
      }
    });

    tbv.addSelectionChangedListener(new ISelectionChangedListener() {
      public void selectionChanged(SelectionChangedEvent event) {
        IStructuredSelection selection = (IStructuredSelection) event
            .getSelection();

        setStatus("Number of items selected is " + selection.size());
      }
    });

    return sash_form;
  }

  public static void main(String[] args) {
    JFaceExplorer w = new JFaceExplorer();
    w.setBlockOnOpen(true);
    w.open();
    Display.getCurrent().dispose();
  }
}

class Util {
  private static ImageRegistry image_registry;

  public static URL newURL(String url_name) {
    try {
      return new URL(url_name);
    } catch (MalformedURLException e) {
      throw new RuntimeException("Malformed URL " + url_name, e);
    }
  }

  public static ImageRegistry getImageRegistry() {
    if (image_registry == null) {
      image_registry = new ImageRegistry();
      image_registry.put("folder", ImageDescriptor
          .createFromURL(newURL("file:icons/folder.gif")));
      image_registry.put("file", ImageDescriptor
          .createFromURL(newURL("file:icons/file.gif")));
    }
    return image_registry;
  }
}

class FileTreeLabelProvider extends LabelProvider {
  public String getText(Object element) {
    return ((File) element).getName();
  }

  public Image getImage(Object element) {
    if (((File) element).isDirectory()) {
      return Util.getImageRegistry().get("folder");
    } else {
      return Util.getImageRegistry().get("file");
    }
  }
}

class FileTreeContentProvider implements ITreeContentProvider {
  public Object[] getChildren(Object element) {
    Object[] kids = ((File) element).listFiles();
    return kids == null ? new Object[0] : kids;
  }

  public Object[] getElements(Object element) {
    return getChildren(element);
  }

  public boolean hasChildren(Object element) {
    return getChildren(element).length > 0;
  }

  public Object getParent(Object element) {
    return ((File) element).getParent();
  }

  public void dispose() {
  }

  public void inputChanged(Viewer viewer, Object old_input, Object new_input) {
  }
}

class FileTableLabelProvider implements ITableLabelProvider {
  public String getColumnText(Object element, int column_index) {
    if (column_index == 0) {
      return ((File) element).getName();
    }

    if (column_index == 1) {
      return "" + ((File) element).length();
    }

    return "";
  }

  public void addListener(ILabelProviderListener ilabelproviderlistener) {
  }

  public void dispose() {
  }

  public boolean isLabelProperty(Object obj, String s) {
    return false;
  }

  public void removeListener(ILabelProviderListener ilabelproviderlistener) {
  }

  public Image getColumnImage(Object element, int column_index) {

    if (column_index != 0) {
      return null;
    }

    if (((File) element).isDirectory()) {
      return Util.getImageRegistry().get("folder");
    } else {
      return Util.getImageRegistry().get("file");
    }
  }
}

class FileTableContentProvider implements IStructuredContentProvider {
  public Object[] getElements(Object element) {
    Object[] kids = null;
    kids = ((File) element).listFiles();
    return kids == null ? new Object[0] : kids;
  }

  public void dispose() {
  }

  public void inputChanged(Viewer viewer, Object old_object, Object new_object) {
  }
}

class FileSorter extends ViewerSorter {
  public int category(Object element) {
    return ((File) element).isDirectory() ? 0 : 1;
  }
}

class AllowOnlyFoldersFilter extends ViewerFilter {
  public boolean select(Viewer viewer, Object parent, Object element) {
    return ((File) element).isDirectory();
  }
}

